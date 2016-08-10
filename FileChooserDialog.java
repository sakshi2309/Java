import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileChooserDialog {
	String filename;
  public File fileSelect() {
    JFileChooser fileopen = new JFileChooser();
   FileFilter filter = new FileNameExtensionFilter("text files", "txt");
    fileopen.addChoosableFileFilter(filter);

    int ret = fileopen.showDialog(null, "Open file");

    if (ret == JFileChooser.APPROVE_OPTION) {}
File      file = fileopen.getSelectedFile();
//filename=String.valueOf(file);
      //System.out.println(file);
      //javax.swing.JOptionPane.showMessageDialog(null,"the file selected is in FileChooserDialog"+file);


    return file;
  }

}