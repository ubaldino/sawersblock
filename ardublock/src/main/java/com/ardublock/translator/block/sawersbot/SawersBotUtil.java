package com.ardublock.translator.block.sawersbot;

import com.ardublock.translator.Translator;

public class SawersBotUtil {

  public static void setupEnv(Translator translator) {
    
    translator.addHeaderFile("Servo.h");
    translator.addHeaderFile("Ultrasonic.h");
    
    translator.addDefinitionCommand( "Ultrasonic ultrasonic( 5 , 12 );" );
    translator.addDefinitionCommand( "int angmax= 180;" );
    translator.addDefinitionCommand( "int angmin= 0;" );
  }

}
