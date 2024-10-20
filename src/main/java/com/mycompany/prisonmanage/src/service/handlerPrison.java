package com.mycompany.prisonmanage.src.service;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.mycompany.prisonmanage.src.model.Prisonal;
import java.io.File;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class handlerPrison {
    private static final String FILE_NAME = "src/main/java/com/mycompany/prisonmanage/src/data/prisoners.json";
    private static final Gson gson = new Gson();
    private static List<Prisonal> prisonals = new ArrayList<>();
    // Khởi tạo: Đọc dữ liệu từ file JSON khi ứng dụng chạy.
    static {
        prisonals = loadPrisonalsFromFile();
    }
    // 1. Đọc danh sách phạm nhân từ file JSON
    private static List<Prisonal> loadPrisonalsFromFile() {
        try (FileReader reader = new FileReader(FILE_NAME)) {
            Type listType = new TypeToken<ArrayList<Prisonal>>() {}.getType();
            return gson.fromJson(reader, listType);
        } catch (IOException | JsonSyntaxException e) {
            System.err.println("Lỗi khi đọc dữ liệu: " + e.getMessage());
            return new ArrayList<>();
        }
    }
    
    

    // 2. Lưu danh sách phạm nhân vào file JSON
    private static void savePrisonalsToFile() {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            gson.toJson(prisonals, writer);
            System.out.println("Đã lưu dữ liệu vào tệp " + FILE_NAME);
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi dữ liệu: " + e.getMessage());
        }
    }

    // 3. Thêm phạm nhân mới
    public static void addPrisonal(Prisonal newPrisonal) {
        prisonals.add(newPrisonal);
        savePrisonalsToFile();
        System.out.println("Đã thêm phạm nhân: " + newPrisonal.getName());
    }

    // 4. Sửa thông tin phạm nhân
    public static void editPrisonal(int id, Prisonal updatedPrisonal) {
        Optional<Prisonal> optionalPrisonal = prisonals.stream()
                .filter(prisonal -> prisonal.getId() == id)
                .findFirst();

        if (optionalPrisonal.isPresent()) {
            Prisonal existingPrisonal = optionalPrisonal.get();
            existingPrisonal.setName(updatedPrisonal.getName());
            existingPrisonal.setAge(updatedPrisonal.getAge());
            existingPrisonal.setCrime(updatedPrisonal.getCrime());
            existingPrisonal.setStatus(updatedPrisonal.getStatus());
            savePrisonalsToFile();
            System.out.println("Đã cập nhật phạm nhân ID: " + id);
        } else {
            System.err.println("Không tìm thấy phạm nhân với ID: " + id);
        }
    }

    // 5. Xóa phạm nhân
    public static void removePrisonal(int id) {
        if (prisonals.removeIf(prisonal -> prisonal.getId() == id)) {
            savePrisonalsToFile();
            System.out.println("Đã xóa phạm nhân với ID: " + id);
        } else {
            System.err.println("Không tìm thấy phạm nhân với ID: " + id);
        }
    }

    // 6. Lấy danh sách tất cả phạm nhân
    public static List<Prisonal> getAllPrisonals() {
        
        return prisonals;
    }

    // 7. Tìm phạm nhân theo ID
    public static Prisonal getPrisonalById(int id) {
        return prisonals.stream()
                .filter(prisonal -> prisonal.getId() == id)
                .findFirst()
                .orElse(null);
    }
    
    // 8. Tìm kiếm theo tên hoặc theo tội danh
    public static List<Prisonal> searchPrisonals(String keyword) {
    keyword = keyword.toLowerCase(); 
    List<Prisonal> results = new ArrayList<>();
    for (Prisonal prisonal : prisonals) {
        if (prisonal.getName().toLowerCase().contains(keyword) ||
            prisonal.getCrime().toLowerCase().contains(keyword)) {
            results.add(prisonal);
        }
    }
    return results;
}


    private static void readJsonFile(File jsonFile) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
