package coffee.util;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Component
public class FileStorageUtil implements FileStorage {

	private final Path rootLocation = Paths.get("filestorage").resolve("images");
	private static int fileCount = 0; 
	
	@Override
	public String store(MultipartFile file) {

		try {
				Files.copy(file.getInputStream(), rootLocation.resolve(String.valueOf(fileCount).concat( file.getOriginalFilename())));
				
				String savedFileName = String.valueOf(fileCount).concat( file.getOriginalFilename()).toString();
				fileCount++;
				return savedFileName;
			
		} catch (IOException e) {
			throw new RuntimeException("FAIL! -> message! = " + e.getMessage());
		}
	}

	@Override
	public Resource loadFile(String filename) {

		try {
			
			Path path = rootLocation.resolve(filename);
			
			Resource resource = new UrlResource(path.toUri());
			
			if(resource.exists() || resource.isReadable()) {
                return resource;
            }else{
            	throw new RuntimeException("FAIL!");
            }
		} catch (MalformedURLException e) {
			throw new RuntimeException("Error! -> message = " + e.getMessage());
		}
		
	}

	@Override
	public void deleteAll() {
		FileSystemUtils.deleteRecursively(rootLocation.toFile());
	}

	@Override
	public void init(HttpSession session) {
		String realPath = session.getServletContext().getRealPath("/");
			
		try {
			if(!Files.exists(rootLocation)) {
				Files.createDirectories(rootLocation);
			}
		} catch (IOException e) {
			 throw new RuntimeException("Could not initialize storage!");
		}
	}

	@Override
	public Stream<Path> loadFiles() {
		try {
            return Files.walk(this.rootLocation, 1)
                .filter(path -> !path.equals(this.rootLocation))
                .map(this.rootLocation::relativize);
        }
        catch (IOException e) {
        	throw new RuntimeException("\"Failed to read stored file");
        }
	}

}
