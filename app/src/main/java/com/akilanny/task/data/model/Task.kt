package com.akilanny.task.data.model;

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
public class Task (
        val id: String,
        val description: String
) : Parcelable

