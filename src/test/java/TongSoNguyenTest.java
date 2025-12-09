import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TongSoNguyenTest {

    private TongSoNguyen tinhTong;

    @BeforeEach
    void CaiDat() {
        tinhTong = new TongSoNguyen();
    }

    // --- Các Test Case Hợp Lệ (Phân vùng Tương đương & Biên) ---

    @Test
    void Test_Tong_Bien_GiaTriNhoNhat() {
        // n=1 là giá trị hợp lệ nhỏ nhất (biên)
        long ketQuaThucTe = tinhTong.TinhTong(1);
        assertEquals(1, ketQuaThucTe);
    }

    @Test
    void Test_Tong_GiaTriTrungBinh() {
        // n=5 là giá trị điển hình trong phân vùng hợp lệ
        // Tổng: 1+2+3+4+5 = 15
        long ketQuaThucTe = tinhTong.TinhTong(5);
        assertEquals(15, ketQuaThucTe);
    }

    @Test
    void Test_Tong_GiaTriLon() {
        // n=100 là giá trị lớn hơn trong phân vùng hợp lệ
        // Tổng: 100 * 101 / 2 = 5050
        long ketQuaThucTe = tinhTong.TinhTong(100);
        assertEquals(5050, ketQuaThucTe);
    }

    // --- Các Test Case Ngoại Lệ (Phân vùng Không hợp lệ) ---

    @Test
    void Test_Tong_Bien_Bang0_NgoaiLe() {
        // n=0 là giá trị không hợp lệ tại biên. Phải ném ngoại lệ.
        assertThrows(IllegalArgumentException.class, () -> {
            tinhTong.TinhTong(0);
        });
    }

    @Test
    void Test_Tong_SoAm_NgoaiLe() {
        // n=-5 là giá trị đại diện cho phân vùng số âm. Phải ném ngoại lệ.
        assertThrows(IllegalArgumentException.class, () -> {
            tinhTong.TinhTong(-5);
        });
    }
}