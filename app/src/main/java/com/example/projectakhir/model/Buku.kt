package com.example.projectakhir.model

class Buku {
    var id: String? = ""
    private var judulBuku: String = ""
    private var namaPengerangBuku: String = ""
    private var deskripsiBuku: String = ""
    private var hargaBuku: String = ""
    private var AlamatToko: String = ""
    constructor():this("","","","","",""){}
    constructor(id: String?, judulBuku: String, namaPengerangBuku: String, deskripsiBuku: String, AlamatToko:String, hargaBuku: String){
        this.id = id
        this.judulBuku = judulBuku
        this.namaPengerangBuku = namaPengerangBuku
        this.deskripsiBuku = deskripsiBuku
        this.hargaBuku = hargaBuku
        this.AlamatToko = AlamatToko
    }

    fun getJudulBuku(): String {
        return judulBuku
    }
    fun setJudulBuku(value: String) {
        judulBuku = value
    }
    fun getNamaPengerangBuku(): String {
        return namaPengerangBuku
    }
    fun setNamaPengerangBuku(value: String) {
        namaPengerangBuku = value
    }
    fun getDeskripsiBuku(): String {
        return deskripsiBuku
    }
    fun setDeskripsiBuku(value: String) {
        deskripsiBuku = value
    }
    fun getHarga(): String {
        return hargaBuku
    }
    fun setHarga(value: String) {
        hargaBuku = value
    }
    fun getAlamatToko(): String {
        return AlamatToko
    }
    fun setAlamatToko(value: String) {
        AlamatToko = value
    }
}