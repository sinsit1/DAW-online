create or replace trigger controla_agentes
before insert or update on agentes for each row
begin
    -- 1- La longitud de la clave de un agente no puede ser inferior a 5.
    if length(:new.clave) < 5 then 
        raise_application_error(-20001, 'La clave no puede ser menor de 5');
    end if;  
    -- 2- La longitud del usuario de un agente no puede ser inferior a 3.
    if length(:new.usuario) < 3 then 
        raise_application_error(-20002, 'La longitud del usuario de un agente  no puede ser inferior a 3');
    end if;
        
    -- 3- La habilidad de un agente debe estar comprendida entre 0 y 9 (ambos inclusive).
    if not(:new.habilidad >= 0 and :new.habilidad <= 9) then
        raise_application_error(-20003, 'La habilidad debe estar entre 0 y 9 incluidos');
    end if;
    
    -- 4- La categoría de un agente sólo puede ser un valor (numérico entero entre el 0 y el 2.
    if :new.categoria not in (0,1,2) then
        raise_application_error(-20004,'La categoria debe ser numérico entero entre el 0 y el 2');
    end if;
    
    -- 5- Si un agente tiene categoría 1 no puede pertenecer a ninguna oficina y debe pertenecer a una familia.
    if :new.categoria = 1 and :new.oficina is not null and :new.familia is null then
        raise_application_error(-20005,'Un agente de categoria 1 no puede pertenecer a una oficina y debe pertenecer a una familia');
    end if;
    
    -- 6- Si un agente tiene categoría 2 no puede pertenecer a ninguna familia y debe pertenecer a una oficina. 
    if :new.categoria = 2 and :new.familia is not null and :new.oficina is null then
        raise_application_error(-20006,'Un agente de categoria 2 no puede pertenecer a una familia y debe pertenecer a una oficina');
    end if;
    
    -- 7- Todos los agentes deben pertenecer a una oficina o a una familia pero nunca a ambas a la vez.
    if ((:new.familia is not null and :new.oficina is not null) or (:new.familia is null and :new.oficina is null)) then
        raise_application_error(-20007,'Un agente debe pertenecer a una oficina O a una familia, NUNCA ambas a la vez');
    end if;

end;
/

-- SENTENCIAS PARA HACER SALTAR LOS TRIGGERS

-- 1- longitud de la clave menos de 5 caracteres
insert into agentes values (705, 'agente 6678', 'usuario6867', '555', 0, 2, null , 3 );

-- 2- longitud usuartio menos de 3
insert into agentes values (705, 'agente 6678', 'us', '1263455', 0, 2, null , 3 );

-- 3- La habilidad de un agente debe estar comprendida entre 0 y 9 (ambos inclusive).
insert into agentes values (705, 'agente 6678', 'usuario6867', '1263455', -3, 2, null , 3 );

-- 4- La categoría de un agente sólo puede ser un valor (numérico entero entre el 0 y el 2.
insert into agentes values (705, 'agente 6678', 'usuario6867', '1263455', 0, 7, null , 3 );

-- 5- Si un agente tiene categoría 1 no puede pertenecer a ninguna oficina y debe pertenecer a una familia.
insert into agentes values (705, 'agente 6678', 'usuario6867', '1263455', 3, 1, null , 1 );

-- 6- Si un agente tiene categoría 2 no puede pertenecer a ninguna familia y debe pertenecer a una oficina. 
insert into agentes values (705, 'agente 6678', 'usuario6867', '1263455', 3, 2, 11 , null );

-- 7-  Todos los agentes deben pertenecer a una oficina o a una familia pero nunca a ambas a la vez.
select * from agentes;

-- INSERT CORRECTO
insert into agentes values (705, 'agente 6678', 'usuario6867', '1263455', 0, 2, null , 3 );


