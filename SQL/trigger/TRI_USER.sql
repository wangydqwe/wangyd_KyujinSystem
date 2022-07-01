CREATE OR REPLACE TRIGGER TRI_USER 
 before insert on USER_TABLE for each row
begin
  select S_USER.Nextval into:new.U_ID from dual;
 end;
/
