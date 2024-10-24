package com.github.curriculeon;

import java.io.IOException;

/**
 * @author leon on 18/11/2018.
 */
public class SpecialCharDocument extends Document {
    public SpecialCharDocument(String fileName) throws IOException {
        super(fileName);
    }

    @Override
    public void write(String contentToBeWritten) {
        if(isSpecialCharacters(contentToBeWritten)){
            super.write(contentToBeWritten);
        }else{
            throw new IllegalArgumentException();
        }
    }

    private Boolean isSpecialCharacters(String s) {
        return !s.matches("\\d+") && !s.matches("[ a-zA-Z]+");
    }
}
