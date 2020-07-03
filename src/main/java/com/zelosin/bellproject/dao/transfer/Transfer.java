package com.zelosin.bellproject.dao.transfer;

public class Transfer {
    public interface Save{}
    public interface Update{}
    public interface Filter{}

    public interface ListView{}
    public interface DetailView extends ListView{};
}
