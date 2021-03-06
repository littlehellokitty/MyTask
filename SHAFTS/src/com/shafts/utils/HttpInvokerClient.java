package com.shafts.utils;
import java.io.*;

import org.ecust.remote.chemmapper.ChemmapperService;
import org.ecust.remote.chemmapper.model.ChemmapperServiceModel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * Realize the network interface to the chemmapper
 * @author Little-Kitty
 * 2014-07-14
 */

public class HttpInvokerClient implements Serializable { 
	//ChemmapperService chemmapperService = new ChemmapperService();
	private static final long serialVersionUID = 4434285410904659989L;
	/**
	 * get the job id 
	 * @param path
	 * 		input file
	 * @param Model
	 * 		the screen model 0 or 1, there are two models called Target Navigator and Hit Explorer
	 * @param outputnum
	 * 		the result number
	 * @param program
	 * 		choose a screen method 3D:FeatureAlign or ShapeFilter,  2D:  FP2 or MACCS
	 * @param screendb
	 * 		choose a screen database 
	 * @param threshold
	 * 		select the screen threshold
	 * @return
	 * 		return the job id
	 */
    public String getid(String path,int Model,String outputnum, String program, String screendb, String threshold){  
        ApplicationContext context = new ClassPathXmlApplicationContext("web.xml");  
        ChemmapperService service = (ChemmapperService) context.getBean("chemmapperService");  
        ChemmapperServiceModel csm = new ChemmapperServiceModel();
        File  file = new File(path);
       // File file = new File();
		
		byte[] input = null;
		if (file.exists()) {
			try {
				InputStream ins = new FileInputStream(file);
				BufferedInputStream bufin = new BufferedInputStream(ins);
				ByteArrayOutputStream out = new ByteArrayOutputStream(1024);
				byte[] temp = new byte[1024];
				int size = 0;
				while ((size = bufin.read(temp)) != -1) {
					out.write(temp, 0, size);
				}
				bufin.close();
				input = out.toByteArray();
				out.close();
				ins.close();

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

        csm.setMode(Model);
        csm.setFileType("mol2");
        csm.setInput(input);
        csm.setOutputNum(outputnum);
        csm.setProgram(program);
        csm.setScreenDb(screendb);
        //csm.setTargetDb("NCI");
        csm.setThreshold(threshold);
        int jobId = service.chemmapper(csm);
        String ID = String.valueOf(jobId);
        return ID;
    }  
}  