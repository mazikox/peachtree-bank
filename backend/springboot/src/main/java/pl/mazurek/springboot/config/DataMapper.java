package pl.mazurek.springboot.config;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import pl.mazurek.springboot.entity.Data;
import pl.mazurek.springboot.entity.DataDto;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Mapper
public interface DataMapper {

    DataMapper INSTANCE = Mappers.getMapper(DataMapper.class);
    LocalDateTime localDateTime = null;

    @Mapping(source = "categoryCode.name", target = "categoryCode")
    @Mapping(target = "date", expression = "java(convertUnixToDate(data.getDate()))")
    DataDto dataToDataDt(Data data);

    default LocalDate convertUnixToDate(Long unixTimestamp) {
        return LocalDate.ofInstant(Instant.ofEpochMilli(unixTimestamp), ZoneId.systemDefault());
    }
}