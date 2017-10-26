import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.heyrul.springwebmvc.config.ApplicationConfig;
import com.heyrul.springwebmvc.models.Karyawan;
import com.heyrul.springwebmvc.services.KaryawanService;

public class KaryawanTest {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext spring = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		KaryawanService service = (KaryawanService) spring.getBean(KaryawanService.class);
		
		Karyawan karyawan = new Karyawan();
		karyawan.setNip("pst678");
		karyawan.setNama("Rully Andhika");
		karyawan.setJabatan("Java Programmer");
		karyawan.setGaji(20000000);
		karyawan.setAlamat("Jakarta");
		service.insertKaryawan(karyawan);
	}

}
