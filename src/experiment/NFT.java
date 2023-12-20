package experiment;



public class NFT {
    protected String collectionId;
    protected String coverUrl;
    protected String title;
    protected String network;
    protected String volume;
    protected String volumeRate;
    protected int ownersCount;
    protected int itemsCount;
    protected String listedCount;
    protected String floorPrice;
    protected String floorPriceRate;
    protected int verified;

    public void setCollectionId(String collectionId) {
        this.collectionId = collectionId;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public void setTitle(String newtitle) {
        this.title = newtitle;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public void setVolumeRate(String volumeRate) {
        this.volumeRate = volumeRate;
    }

    public void setOwnersCount(int ownersCount) {
        this.ownersCount = ownersCount;
    }

    public void setItemsCount(int itemsCount) {
        this.itemsCount = itemsCount;
    }

    public void setListedCount(String listedCount) {
        this.listedCount = listedCount;
    }

    public void setFloorPrice(String floorPrice) {
        this.floorPrice = floorPrice;
    }

    public void setFloorPriceRate(String floorPriceRate) {
        this.floorPriceRate = floorPriceRate;
    }

    public void setVerified(int verified) {
        this.verified = verified;
    }
    public String getCollectionId() {
        return collectionId;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getNetwork() {
        return network;
    }

    public String getVolume() {
        return volume;
    }

    public String getVolumeRate() {
        return volumeRate;
    }

    public int getOwnersCount() {
        return ownersCount;
    }

    public int getItemsCount() {
        return itemsCount;
    }

    public String getListedCount() {
        return listedCount;
    }

    public String getFloorPrice() {
        return floorPrice;
    }

    public String getFloorPriceRate() {
        return floorPriceRate;
    }

    public int getVerified() {
        return verified;
    }

}
