package com.poli.taller1pds.mapper;

public interface IMapper <Input, Output>{
    public Output map(Input in);
}

