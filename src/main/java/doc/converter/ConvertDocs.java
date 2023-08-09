package doc.converter;

import org.jodconverter.core.office.OfficeException;
import org.jodconverter.core.office.OfficeManager;
import org.jodconverter.core.office.OfficeUtils;
import org.jodconverter.local.JodConverter;
import org.jodconverter.local.office.LocalOfficeManager;

import java.io.File;

public class ConvertDocs {

    static OfficeManager officeManagerBuilder = LocalOfficeManager
            .builder()
            .install()
            .officeHome("\\LibreOffice")
            .build();





    public static void main(String[] args) throws OfficeException {

        File inputFile = new File(args[0]);
        File outputFile = new File(args[1]);
        try {
            new ConvertDocs().officeManagerBuilder.start();

            JodConverter.convert(inputFile).to(outputFile).execute();

        }
        finally {
            OfficeUtils.stopQuietly(officeManagerBuilder);
        }


    }







}
