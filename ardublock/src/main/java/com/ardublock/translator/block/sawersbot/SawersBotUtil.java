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

}
