package com.project.side.moyora.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RoomVo {
    @JsonProperty
    private final long roomNo;
    @JsonProperty
    private Coordinate destination;
    @JsonProperty
    private String password;
    @JsonProperty
    private List<GuestVo> guestVoList = new ArrayList<>();

    public RoomVo(long roomNo, GuestVo guestVo, String password) {
        this.roomNo = roomNo;
        this.password = password;
        this.guestVoList.add(guestVo);
    }

    public long getRoomNo() {
        return roomNo;
    }

    public Coordinate getDestination() {
        return destination;
    }

    public List<GuestVo> getGuestVoList(){ return guestVoList; }
    public void setDestination(Coordinate destination) {
        this.destination = destination;
    }

    public GuestVo setNewGuest(){
        long newGuestNo = getNewGuestNo();
        GuestVo itsMe = new GuestVo(newGuestNo);
        guestVoList.add(itsMe);
        return itsMe;
    }

    public long getNewGuestNo(){
        Long newGuestNo = null;
        if(guestVoList.size() > 0){
            for(GuestVo guest : guestVoList ){
                long gNo = guest.getGuestNo();
                if(newGuestNo == null || newGuestNo < gNo ){
                    newGuestNo = gNo;
                }
            }
        }
        return newGuestNo == null ? 0 : newGuestNo;
    }

    public void addPointOnGuest(long id, double x, double y){
        Optional<GuestVo> optMe =
            guestVoList.stream().filter(guestVo -> guestVo.getGuestNo() == id).findFirst();
        if(optMe.isPresent()){
            GuestVo me = optMe.get();
            me.appendCoordAtMovingLog(x, y);
        }
    }

    public boolean comaprePassword(String pw){
        return this.password.equals(pw);
    }

    public GuestVo getOneGuestInfo(Long guestId) {
        Optional<GuestVo> og = this.guestVoList.stream()
            .filter(x -> x.getGuestNo() == guestId).findFirst();
        return og.orElse(null);
    }

    public GuestVo setColorOnGuest(long guestNo, String color) {
        Optional<GuestVo> optMe =
            guestVoList.stream().filter(guestVo -> guestVo.getGuestNo() == guestNo).findFirst();
        if(optMe.isPresent()){
            GuestVo me = optMe.get();
            me.setColor(color);
            return me;
        }
        return null;
    }
}
