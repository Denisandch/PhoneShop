package com.example.domain.usecase

import com.example.domain.model.PhoneDescription
import com.example.domain.repository.RepositoryToData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.junit.Assert
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito


class PhoneDescriptionCachedDataSourceTest {

    @Mock
    lateinit var repo: RepositoryToData

    @Test
    fun shouldReturnCorrectData() {


        val testData = PhoneDescription(1, "phone", 123, "description", listOf("pictureURL"))


        CoroutineScope(Dispatchers.IO).launch {
            Mockito.`when`(repo.getPhoneDescription(-1)).thenReturn(testData)
            val phoneDescriptionCachedDataSource = PhoneDescriptionCachedDataSource(repo)

            val actual = phoneDescriptionCachedDataSource.getData()
            val expected = 7

            Assert.assertEquals(actual, expected)
        }
    }
}