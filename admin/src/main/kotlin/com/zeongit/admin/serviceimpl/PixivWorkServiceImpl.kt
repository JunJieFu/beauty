package com.zeongit.admin.serviceimpl

import com.zeongit.admin.service.PixivWorkService
import com.zeongit.data.database.admin.dao.PixivWorkDao
import com.zeongit.data.database.admin.entity.PixivWork
import com.zeongit.share.exception.NotFoundException
import org.springframework.stereotype.Service

@Service
class PixivWorkServiceImpl(private val pixivWorkDao: PixivWorkDao) : PixivWorkService {
    override fun save(pixivWork: PixivWork): PixivWork {
        return pixivWorkDao.save(pixivWork)
    }

    override fun existsByPixivId(pixivId: String): Boolean {
        return pixivWorkDao.existsByPixivId(pixivId)
    }

    override fun getByPixivId(pixivId: String): PixivWork {
        return pixivWorkDao.getByPixivId(pixivId).orElseThrow { NotFoundException("图片不存在") }
    }

}