package apps.tabngo.cmd;

import java.io.File;

import org.nebula.util.TargetController;

import apps.tabngo.cmd.models.FolderChecksum;
import apps.tabngo.cmd.models.ChecksumUtils;

public class folder_sumtar extends TargetController
{
	@Override
	public void processRequest() 
	throws Exception 
	{
		System.out.println("Comparing WAR to checksum");
		File f1 = super.printParam("war-file: ", this.mongoArgs.getInputFile());
		File f2 = super.printParam("sum-file: ", this.mongoArgs.getCmpFile());
		File f3 = super.printParam("output: ", this.mongoArgs.getOutputFile());
		
		ChecksumUtils.compare(
				FolderChecksum.fromFolder(f1), 
				FolderChecksum.fromJson(f2), f3);
		
		super.showFileIf(f3);
	}


}
