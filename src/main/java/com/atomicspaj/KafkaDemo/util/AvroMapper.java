package com.atomicspaj.KafkaDemo.util;

import com.atomicspaj.KafkaDemo.model.User;
import com.atomicspaj.KafkaDemo.model.UserEntityAvro;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.Schema;
import org.apache.avro.SchemaBuilder;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.Encoder;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.reflect.AvroSchema;
import org.apache.avro.specific.SpecificDatumWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Slf4j
@Service
public class AvroMapper {

    @Autowired
    ObjectMapper objectMapper;

    public byte[] serilalizeUserEnityAvro(UserEntityAvro userEntityAvro)
    {

        DatumWriter<UserEntityAvro> writer = new SpecificDatumWriter<>(
                UserEntityAvro.class);
        byte[] data = new byte[0];
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        Encoder jsonEncoder = null;
        try {
            jsonEncoder = EncoderFactory.get().jsonEncoder(
                    UserEntityAvro.getClassSchema() , stream);
            writer.write(userEntityAvro , jsonEncoder);
            jsonEncoder.flush();
            data = stream.toByteArray();
        }
        catch (IOException e) {
            log.error("Serialization error:" + e.getMessage());
        }
        return data;


    }
}
