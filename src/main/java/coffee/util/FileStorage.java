package coffee.util;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.nio.file.Path;
import java.util.stream.Stream;

public interface FileStorage {
	
	public String store(MultipartFile file);
	public Resource loadFile(String filename);
	public void deleteAll();
	public void init(HttpSession session);
	public Stream<Path> loadFiles();
}
