package parsing;
import java.io.FileReader;

import org.xml.sax.InputSource;
import org.xml.sax.helpers.DefaultHandler;

public class SimulationParser extends DefaultHandler {
	
    public SimulationParser () {
    	super();
    }

    public static void main (String args[]) throws Exception {
    	XMLReader xr = gnu.xml.aelfred2.XmlReader();
    	SimulationParser handler = new SimulationParser();
    	xr.setContentHandler(handler);
    	xr.setErrorHandler(handler);
    		// Parse each file provided on the
    		// command line.
    	for (int i = 0; i < args.length; i++) {
    		FileReader r = new FileReader(args[i]);
    		xr.parse(new InputSource(r));
    	}
    }
}
