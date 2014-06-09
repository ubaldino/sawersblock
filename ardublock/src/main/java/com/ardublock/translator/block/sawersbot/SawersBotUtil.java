package com.ardublock.translator.block.sawersbot;

import com.ardublock.translator.Translator;

public class SawersBotUtil {

  public static void setupWire(Translator translator) {
    translator.addHeaderFile( "Wire.h" );
    translator.addSetupCommand( "Wire.begin();" );
  }
  public static void setupSerial(Translator translator) {
    translator.addSetupCommand( "Serial.begin( 9600 );" );
  }
  
  public static void setupSerial1(Translator translator) {
    translator.addSetupCommand( "Serial1.begin( 9600 );" );
  }
  
  public static void setupServosRueda( Translator translator ){
    translator.addHeaderFile("Servo.h");
    translator.addDefinitionCommand("Servo servo_pin_8;");
    translator.addDefinitionCommand("Servo servo_pin_9;");
    translator.addSetupCommand("servo_pin_8.attach( 8 );\nservo_pin_9.attach( 9 );");
  }
  
  public static boolean isNumeric( String input ) {
    try {
      Integer.parseInt(input);
      return true;
    }
    catch (NumberFormatException e) {
      return false;
    }
  }

}
