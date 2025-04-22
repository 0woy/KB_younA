package Adapter.adapter02;

public class PrintBanner extends Print{
    private Banner banner;
    public PrintBanner(String string) {
        this.banner = new Banner(string);
    }
    public PrintBanner(Banner banner) {
        this.banner = banner;
    }

    @Override
    public void printWeak() {
        banner.showWithParen();
    }

    @Override
    public void printStrong() {
        banner.showWithAster();
    }
}
