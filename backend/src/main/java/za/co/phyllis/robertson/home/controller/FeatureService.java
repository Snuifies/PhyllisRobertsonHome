package za.co.phyllis.robertson.home.controller;

import org.springframework.stereotype.Service;

/**
 * Simple service for example purposes
 */
@Service
public class FeatureService {

	public Integer getSum(Integer valueA, Integer valueB) {
		return valueA + valueB;
	}
}
