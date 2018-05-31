package com.kyland;

/***
 * @Author: achen
 * @Date: ${time} ${date}
 * @Description:
 ***/
public class Pod {

    /**
     * podName : renqiao-539f5a63-1670453663-32frd
     * status : Running
     * podIP : 10.182.79.119
     * hostIP : 172.22.157.63
     * containerID : null
     * image : public/mysql:5.5.38v2
     * flavor : {"memory":"2Gi","cpu":"2"}
     * createTime : 2018-03-20T03:47:38Z
     * lbStatus : null
     * jsfStatus : null
     * uuid : 6eec998d-2bf1-11e8-9447-e41f13eec0b2
     */

    Pod(int i){
            this.setPodIP(getPodIP()+">>>>>>>>>>"+i);
    }
    Pod()
    {
        this.setHostIP("");
        this.setCreateTime("");
        this.setPodName("");
        this.setStatus("");
        this.setImage("");
        this.setUuid("");
    }
    private String podName = "renqiao-539f5a63-1670453663-32frd";
    private String status  = "Running";
    private String podIP = "10.182.79.119";
    private String hostIP = "172.22.157.63";
    private Object containerID;
    private String image = "public/mysql:5.5.38v2";
    private FlavorBean flavor;
    private String createTime = "2018-03-20T03:47:38Z";
    private Object lbStatus;
    private Object jsfStatus;
    private String uuid = "6eec998d-2bf1-11e8-9447-e41f13eec0b2";

    public String getPodName() {
        return podName;
    }

    public void setPodName(String podName) {
        this.podName = podName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPodIP() {
        return podIP;
    }

    public void setPodIP(String podIP) {
        this.podIP = podIP;
    }

    public String getHostIP() {
        return hostIP;
    }

    public void setHostIP(String hostIP) {
        this.hostIP = hostIP;
    }

    public Object getContainerID() {
        return containerID;
    }

    public void setContainerID(Object containerID) {
        this.containerID = containerID;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public FlavorBean getFlavor() {
        return flavor;
    }

    public void setFlavor(FlavorBean flavor) {
        this.flavor = flavor;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Object getLbStatus() {
        return lbStatus;
    }

    public void setLbStatus(Object lbStatus) {
        this.lbStatus = lbStatus;
    }

    public Object getJsfStatus() {
        return jsfStatus;
    }

    public void setJsfStatus(Object jsfStatus) {
        this.jsfStatus = jsfStatus;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public static class FlavorBean {
        /**
         * memory : 2Gi
         * cpu : 2
         */

        private String memory;
        private String cpu;

        public String getMemory() {
            return memory;
        }

        public void setMemory(String memory) {
            this.memory = memory;
        }

        public String getCpu() {
            return cpu;
        }

        public void setCpu(String cpu) {
            this.cpu = cpu;
        }
    }


    public void a()
    {
        this.setHostIP("");
        this.setCreateTime("");
        this.setPodName("");
        this.setStatus("");
        this.setImage("");
        this.setUuid("");
    }
}

