package com.mycompany.prisonmanage;

// Import đúng class GUI
import com.mycompany.prisonmanage.src.ui.PrisonManagementGUI;

public class main {
    public static void main(String[] args) {
        // Sử dụng EventQueue để chạy GUI trên luồng UI
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PrisonManagementGUI().setVisible(true);
            }
        });
    }
}
