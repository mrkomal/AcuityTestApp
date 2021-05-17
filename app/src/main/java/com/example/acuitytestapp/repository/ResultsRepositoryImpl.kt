package com.example.acuitytestapp.repository

class ResultsRepositoryImpl(
    override var numLeftEye: Int = 0,
    override var numRightEye: Int = 0,
    override var maxLeftEye: Int = 0,
    override var maxRightEye: Int = 0,
    override var lenPowerLeftEye: Double = 0.0,
    override var lenPowerRightEye: Double = 0.0
) : ResultRepository