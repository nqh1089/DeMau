public class TongSoNguyen {

    public long TinhTong(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Gia tri n phai la so nguyen duong.");
        }
        return (long) n * (n + 1) / 2;
    }
}