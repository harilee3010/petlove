package com.stc.petlove;

import com.stc.petlove.entities.TaiKhoan;
import com.stc.petlove.repositories.TaiKhoanRepository;
import com.stc.petlove.utils.EnumRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class PetLoveApplication implements CommandLineRunner {
    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    public static void main(String[] args) {
        SpringApplication.run(PetLoveApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        if(taiKhoanRepository.count()==0) {
            TaiKhoan taiKhoan = new TaiKhoan("HaiLe", "Hainaruto01@gmail.com", "123456","0123456789", Arrays.asList(EnumRole.ADMIN.name()));
            taiKhoanRepository.save(taiKhoan);
        }
    }

}
