package com.github.curriculeon;

import java.io.IOException;

/**
 * @author leon on 16/11/2018.
 */
public class AlphaCharDocument extends Document {
    public AlphaCharDocument(String fileName) throws IOException {
        super(fileName);
    }

    @Override
    public void write(String contentToBeWritten) {

            if(!isAlpha(contentToBeWritten)){
                System.out.println("insdie");
                throw new IllegalArgumentException();
            }else{
                System.out.println("hello");
                super.write(contentToBeWritten);
            }



    }

    private Boolean isAlpha(String s) {
       return s.matches("[ a-zA-Z]+");
    }
}
