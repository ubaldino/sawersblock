package com.ardublock.translator.block.sawersbot;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class StopBlock extends TranslatorBlock {

  public StopBlock(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label) {
    super(blockId, translator, codePrefix, codeSuffix, label);

  }

  @Override
  public String toCode() throws SocketNullException, SubroutineNotDeclaredException {
    //SawersBotUtil.setupEnv(translator);
    translator.addHeaderFile("Servo.h");
    translator.addDefinitionCommand("Servo servo_pin_8;");
    translator.addDefinitionCommand("Servo servo_pin_9;");
    
    translator.addSetupCommand("servo_pin_8.attach( 8 );\nservo_pin_9.attach( 9 );");
    
    String secuencia = "servo_pin_8.write( 90 );\nservo_pin_9.write( 90 );\nservo_pin_8.detach();\nservo_pin_9.detach();\n";
    return codePrefix + secuencia + codeSuffix+"\n";
  }

}
