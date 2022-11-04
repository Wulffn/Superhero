public class SuperheroSortingV1 {

    private boolean ascending;
    private SortType sortType;

    public SuperheroSortingV1(boolean ascending, SortType sortType) {
        this.ascending = ascending;
        this.sortType = sortType;
    }

    public boolean isAscending() {
        return ascending;
    }

    public SortType getSort() {
        return sortType;
    }
}
