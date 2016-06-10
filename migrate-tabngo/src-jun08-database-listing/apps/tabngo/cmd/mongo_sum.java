package apps.tabngo.cmd;

import java.io.File;

import org.nebula.mongo.MongoAccess;
import org.nebula.util.TargetController;

import apps.tabngo.cmd.models.MongoChecksum;

public class mongo_sum extends TargetController
{
	@Override
	public void processRequest() throws Exception 
	{
		System.out.println("Creating checksum file for WAR file");
		String f1 = super.printParam("input: ", this.mongoArgs.getDatabaseName(""));
		File f2 = super.printParam("output: ", this.mongoArgs.getOutputFile());
		
		MongoAccess.writeJson(MongoChecksum.fromFolder(f1), f2);
		
		super.showFileIf(f2);
	}

}