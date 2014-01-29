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
    translator.addDefinitionCommand("Servo servo_pin_9;");
    translator.addDefinitionCommand("Servo servo_pin_10;");
    
    translator.addSetupCommand("servo_pin_9.attach( 9 );\nservo_pin_10.attach( 10 );");
    
    TranslatorBlock tb = this.getRequiredTranslatorBlockAtSocket( 0 );
    
    String secuencia = "servo_pin_9.write( 90 );\nservo_pin_10.write( 90 );\n"+"delay( "+tb.toCode()+" );";
    return codePrefix + secuencia + codeSuffix+"\n";
  }

}
