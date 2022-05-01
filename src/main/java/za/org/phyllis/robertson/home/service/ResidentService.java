package za.org.phyllis.robertson.home.service;

import ch.qos.logback.core.boolex.EvaluationException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.org.phyllis.robertson.home.entity.*;
import za.org.phyllis.robertson.home.exception.ResourceNotFoundException;
import za.org.phyllis.robertson.home.model.*;
import za.org.phyllis.robertson.home.repository.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Log4j2
@Service
public class ResidentService {

    ResidentRepository residentRepository;
    ResidentDailyCareRepository careRepository;
    ResidentMealRepository mealRepository;
    ResidentConditionRepository conditionRepository;
    ResidentPrescriptionRepository prescriptionRepository;

    @Autowired
    public ResidentService(ResidentRepository residentRepository,
                           ResidentDailyCareRepository careRepository,
                           ResidentMealRepository mealRepository,
                           ResidentConditionRepository conditionRepository,
                           ResidentPrescriptionRepository prescriptionRepository) {
        this.residentRepository = residentRepository;
        this.careRepository = careRepository;
        this.mealRepository = mealRepository;
        this.conditionRepository = conditionRepository;
        this.prescriptionRepository = prescriptionRepository;
    }

    @Transactional
    public List<ResidentDO> findAllResidents() {
        List<Resident> residents = residentRepository.findAll();
        return residents.stream().map(ResidentDO::new).collect(Collectors.toList());
    }

    @Transactional
    public ResidentDO findResidentByIdNumber(String idNumber) throws ResourceNotFoundException {
        Optional<Resident> resident = residentRepository.findByIdNumber(idNumber);
        resident.orElseThrow(() -> new ResourceNotFoundException("Resident", String.format("ID Number [%s]", idNumber)));
        return resident.map(ResidentDO::new).get();
    }

    @Transactional
    public ResidentDO findResidentByNickName(String nickName) throws ResourceNotFoundException {
        Optional<Resident> resident = residentRepository.findByNickName(nickName);
        resident.orElseThrow(() -> new ResourceNotFoundException("Resident", String.format("NickName [%s]", nickName)));
        return resident.map(ResidentDO::new).get();
    }

    @Transactional
    public ResidentDO updateResidentByNickName(String idNumber, String newNickName) throws ResourceNotFoundException {
        Optional<Resident> resident = residentRepository.findByIdNumber(idNumber);
        resident.orElseThrow(() -> new ResourceNotFoundException("Resident", String.format("ID Number [%s]", idNumber)));
        resident.get().setNickName(newNickName);
        residentRepository.save(resident.get());
        return resident.map(ResidentDO::new).get();
    }

    public ResidentDailyCareDO findDailyCareByResidentIdNumber(String idNumber) throws ResourceNotFoundException {
        Optional<Resident> resident = residentRepository.findByIdNumber(idNumber);
        resident.orElseThrow(() -> new ResourceNotFoundException("Resident", String.format("ID Number [%s]", idNumber)));
        ResidentDailyCare dailyCare = resident.get().getResidentDailyCare();
        return new ResidentDailyCareDO(dailyCare);
    }

    @Transactional
    public ResidentDailyCareDO updateResidentDailyCareBathType(String idNumber, BathType bathType) throws ResourceNotFoundException {
        Optional<Resident> resident = residentRepository.findByIdNumber(idNumber);
        resident.orElseThrow(() -> new ResourceNotFoundException("Resident", String.format("ID Number [%s]", idNumber)));
        ResidentDailyCare dailyCare = resident.get().getResidentDailyCare();
        dailyCare.setBath(bathType);
        careRepository.save(dailyCare);
        return new ResidentDailyCareDO(dailyCare);
    }

    @Transactional
    public ResidentMealDO findResidentMealByResidentIdNumber(String idNumber) throws ResourceNotFoundException {
        Optional<Resident> resident = residentRepository.findByIdNumber(idNumber);
        resident.orElseThrow(() -> new ResourceNotFoundException("Resident", String.format("ID Number [%s]", idNumber)));
        ResidentMeal residentMeal = resident.get().getResidentMeal();
        return new ResidentMealDO(residentMeal);
    }

    @Transactional
    public ResidentMealDO updateResidentMealDietType(String idNumber, DietType dietType) throws ResourceNotFoundException {
        Optional<Resident> resident = residentRepository.findByIdNumber(idNumber);
        resident.orElseThrow(() -> new ResourceNotFoundException("Resident", String.format("ID Number [%s]", idNumber)));
        ResidentMeal residentMeal = resident.get().getResidentMeal();
        residentMeal.setDietType(dietType);
        mealRepository.save(residentMeal);
        return new ResidentMealDO(residentMeal);
    }

    @Transactional
    public List<ResidentConditionDO> findResidentConditionsByResidentIdNumber(String idNumber) {
        List<ResidentCondition> conditions = conditionRepository.findByResidentIdNumber(idNumber);
        return conditions.stream().map(ResidentConditionDO::new).collect(Collectors.toList());
    }

    @Transactional
    public List<ResidentConditionDO> addResidentCondition(String idNumber, String newCondition) throws ResourceNotFoundException {
        Optional<Resident> resident = residentRepository.findByIdNumber(idNumber);
        resident.orElseThrow(() -> new ResourceNotFoundException("Resident", String.format("ID Number [%s]", idNumber)));
        List<ResidentCondition> conditions = conditionRepository.findByResidentIdNumber(idNumber);
        Optional<ResidentCondition> existingCondition = conditions.stream().filter(s -> s.getCondition().equalsIgnoreCase(newCondition)).findFirst();
        if (!existingCondition.isPresent()) {
            ResidentCondition condition = ResidentCondition.builder().resident(resident.get()).condition(newCondition).build();
            conditionRepository.save(condition);
        }
        return conditionRepository.findByResidentIdNumber(idNumber).stream().map(ResidentConditionDO::new).collect(Collectors.toList());
    }

    @Transactional
    public List<ResidentConditionDO> deleteResidentCondition(String idNumber, String condition) {
        List<ResidentCondition> conditions = conditionRepository.findByResidentIdNumber(idNumber);
        Optional<ResidentCondition> existing = conditions.stream().filter(s -> s.getCondition().equalsIgnoreCase(condition)).findFirst();
        if (existing.isPresent()) {
            conditionRepository.delete(existing.get());
        }
        return conditionRepository.findByResidentIdNumber(idNumber).stream().map(ResidentConditionDO::new).collect(Collectors.toList());
    }

    @Transactional
    public List<ResidentPrescriptionDO> findResidentPrescriptions(String idNumber) {
        List<ResidentPrescription> prescriptions = prescriptionRepository.findByResidentIdNumber(idNumber);
        return prescriptions.stream().map(ResidentPrescriptionDO::new).collect(Collectors.toList());

    }

    @Transactional
    public List<ResidentPrescriptionDO> addResidentPrescriptions(String idNumber, String prescription) throws ResourceNotFoundException {
        Optional<Resident> resident = residentRepository.findByIdNumber(idNumber);
        resident.orElseThrow(() -> new ResourceNotFoundException("Resident", String.format("ID Number [%s]", idNumber)));
        List<ResidentPrescription> prescriptions = prescriptionRepository.findByResidentIdNumber(idNumber);
        Optional<ResidentPrescription> existing = prescriptions.stream().filter(s -> s.getPrescription().equalsIgnoreCase(prescription)).findFirst();
        if (!existing.isPresent()) {
            ResidentPrescription condition = ResidentPrescription.builder().resident(resident.get()).prescription(prescription).build();
            prescriptionRepository.save(condition);
        }
        return prescriptionRepository.findByResidentIdNumber(idNumber).stream().map(ResidentPrescriptionDO::new).collect(Collectors.toList());
    }

    @Transactional
    public List<ResidentPrescriptionDO> deleteResidentPrescription(String idNumber, String prescription) {
        List<ResidentPrescription> prescriptions = prescriptionRepository.findByResidentIdNumber(idNumber);
        Optional<ResidentPrescription> existing = prescriptions.stream().filter(s -> s.getPrescription().equalsIgnoreCase(prescription)).findFirst();
        if (existing.isPresent()) {
            prescriptionRepository.delete(existing.get());
        }
        return prescriptionRepository.findByResidentIdNumber(idNumber).stream().map(ResidentPrescriptionDO::new).collect(Collectors.toList());
    }

}
