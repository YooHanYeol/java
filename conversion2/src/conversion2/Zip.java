package conversion2;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
public class Zip {
  public static void decompress(String zipFileName, String directory) throws Throwable {
    File zipFile = new File(zipFileName);
    FileInputStream fis = null;
    ZipInputStream zis = null;
    ZipEntry zipentry = null;
    try {
      
      fis = new FileInputStream(zipFile);
      zis = new ZipInputStream(fis);
      while ((zipentry = zis.getNextEntry()) != null) {
        String filename = zipentry.getName();
        File file = new File(directory, filename);
        if (zipentry.isDirectory()) {
          file.mkdirs();
        } else {
          //파일이면 파일 만들기
          createFile(file, zis);
        }
      }
    } catch (Throwable e) {
      throw e;
    } finally {
      if (zis != null)
        zis.close();
      if (fis != null)
        fis.close();
    }
  }
  private static void createFile(File file, ZipInputStream zis) throws Throwable {
    //디렉토리 확인
    File parentDir = new File(file.getParent());
    //디렉토리가 없으면 생성
    if (!parentDir.exists()) {
      parentDir.mkdirs();
    }
    //파일 스트림 선언
    try (FileOutputStream fos = new FileOutputStream(file)) {
      byte[] buffer = new byte[256];
      int size = 0;
    
      while ((size = zis.read(buffer)) > 0) {
        //byte로 파일 만들기
        fos.write(buffer, 0, size);
      }
    } catch (Throwable e) {
      throw e;
    }
  }
  public static void main(String[] args){
    try{
      Zip.decompress("C:\\dex2jar-2.0\\InsecureBankv2.zip", "C:\\dex2jar-2.0");
      System.out.println("zip파일 압축해제 성공");
    }catch(Throwable e){
      e.printStackTrace();
    }
  }
}
