/*select constraint_name from information_schema.constraint_column_usage
where table_name = 'users_roles' and column_name = 'role_id'
and constraint_name <> 'unique_user_role';

alter table users_roles drop CONSTRAINT  "ukk2mq1ee4ob6uw649wgaus1ate"*/