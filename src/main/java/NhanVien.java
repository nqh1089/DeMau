public class NhanVien {
    private String maNV;
    private String tenNV;
    private int tuoi;
    private double luong;
    private String phongBan;

    public NhanVien(String maNV, String tenNV, int tuoi, double luong, String phongBan) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.tuoi = tuoi;
        this.luong = luong;
        this.phongBan = phongBan;
    }

    // Cần các Getter để Service có thể kiểm tra (nếu cần) và Test có thể Assert
    public String getMaNV() { return maNV; }
    public String getTenNV() { return tenNV; }
    public double getLuong() { return luong; }
}