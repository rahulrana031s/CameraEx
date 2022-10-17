package com.example.locustest.modal

data class LocusDataModalItem(
    val dataMap: DataMap,
    val id: String,
    val title: String,
    val type: String,
    var uri: String,

    val viewType: Int

)