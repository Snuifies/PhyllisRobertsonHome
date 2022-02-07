SELECT u.username, u."password", u.email, r.user_role
FROM rhome.users u
         join rhome.user_roles ur on u.id = ur.user_id
         join rhome.roles r on r.id = ur.role_id
;

SELECT * FROM rhome.users;
SELECT * FROM rhome.roles;
SELECT * FROM rhome.user_roles;


update rhome.users set password = '$2a$12$jpyaUqh/kCjMfTefwVzGXem6aMTSY4cE7oGvctgodhpSW9cGb.4iW' where username='snuifies';
