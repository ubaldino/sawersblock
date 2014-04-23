package com.ardublock.translator.block.sawersbot;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class AdelanteBlock extends TranslatorBlock {

  public AdelanteBlock(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label) {
    super(blockId, translator, codePrefix, codeSuffix, label);

  }

  @Override
  public String toCode() throws SocketNullException, SubroutineNotDeclaredException {

    //SawersBotUtil.setupEnv(translator);
    
	TranslatorBlock tb = this.getRequiredTranslatorBlockAtSocket( 0 );

    
    int velocity = Integer.parseInt( tb.toCode() );
    
    translator.addHeaderFile("Servo.h");
    translator.addDefinitionCommand("Servo servo_pin_8;");
    translator.addDefinitionCommand("Servo servo_pin_9;");
    
    translator.addSetupCommand("servo_pin_8.attach( 8 );\nservo_pin_9.attach( 9 );");
    
    //   0   ->  90
    //   90  ->  0
	tb = this.getRequiredTranslatorBlockAtSocket( 1 );
    
    String secuencia = "servo_pin_8.write( "+( 90 + velocity )+" );\nservo_pin_9.write( "+( 90 - velocity )+" );\n"+"delay( "+tb.toCode()+" );";
    
    
    return codePrefix + secuencia + codeSuffix+"\n";
  }
}
