package com.ardublock.translator.block;

import com.ardublock.translator.Translator;

/**
 *
 * @author ubaldino
 */
public class VariableStringBlock extends TranslatorBlock {

    public VariableStringBlock( Long blockId, Translator translator, String codePrefix, String codeSuffix, String label) {
        super(blockId, translator, codePrefix, codeSuffix, label);
    }

    @Override
    public String toCode() {
        String internalVariableName = translator.getNumberVariable(label);
        if (internalVariableName == null) {
            internalVariableName = translator.buildVariableName(label);
            translator.addNumberVariable(label, internalVariableName);
            translator.addDefinitionCommand("String " + internalVariableName + " = \"\" ;");
//			translator.addSetupCommand(internalVariableName + " = 0;");
        }
        return codePrefix + internalVariableName + codeSuffix;
    }
}
