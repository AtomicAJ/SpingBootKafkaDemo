package com.atomicspaj.KafkaDemo.util;

import com.atomicspaj.KafkaDemo.constants.KafkaDemoConstants;
import org.apache.avro.Schema;
import org.apache.avro.compiler.specific.SpecificCompiler;

import java.io.File;
import java.io.IOException;

public class AvroClassGenerator {

    /*public void generateAvroClasses() throws IOException {
        SpecificCompiler
                compiler = new SpecificCompiler(new Schema.Parser().parse(new File(KafkaDemoConstants.AVRO_USER_SCHEMA_LOC)));
        compiler.compileToDestination(new File(KafkaDemoConstants.AVRO_SOURCE_LOC), new File(KafkaDemoConstants.AVRO_DEST_LOC));
    }*/

}
