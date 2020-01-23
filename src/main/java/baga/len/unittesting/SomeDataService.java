package baga.len.unittesting;

public class SomeDataService {
    private DataInterface dataInterface;

    public void setDataInterface(DataInterface dataInterface) {
        this.dataInterface = dataInterface;
    }

    public int sumAllData() {
        int[] dataArchives = dataInterface.sumData();
        int sum = 0;
        for(int dataArchive : dataArchives) {
            sum += dataArchive;
        }
        return sum;
    }
}
