CREATE OR REPLACE TRIGGER TRI_USER_ROLE 
 before insert on USER_ROLE_TABLE for each row
begin
  select S_USER_ROLE.Nextval into:new.UR_ID from dual;
 end;
/
