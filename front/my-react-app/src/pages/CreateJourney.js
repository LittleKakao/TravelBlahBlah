import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';

export default function CreateJourney() {
    const navigate = useNavigate();
    const [formData, setFormData] = useState({
        journeyName: '',
        journeyDestination: '',
        journeyStartDate: '',
        journeyEndDate: ''
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({
            ...formData,
            [name]: value
        });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post('http://15.165.184.182:8080/journey', formData);
            console.log('API 응답:', response.data);

            // 메인 화면으로 이동
            navigate('/'); // navigate로 페이지 이동
        } catch (error) {
            console.error('API 요청 실패:', error);
            // API 요청 실패 시 에러 처리
        }
    };

    return (
        <div className="container mt-5">
            <h1>여행 등록</h1>
            <form onSubmit={handleSubmit}>
                <div className="row mb-3">
                    <div className="col-md-6">
                        <label htmlFor="journeyName" className="form-label">여행 제목:</label>
                        <input type="text" className="form-control" id="journeyName" name="journeyName" value={formData.journeyName} onChange={handleChange} required />
                    </div>
                    <div className="col-md-6">
                        <label htmlFor="journeyDestination" className="form-label">목적지:</label>
                        <input type="text" className="form-control" id="journeyDestination" name="journeyDestination" value={formData.journeyDestination} onChange={handleChange} required />
                    </div>
                </div>
                <div className="row mb-3">
                    <div className="col-md-6">
                        <label htmlFor="journeyStartDate" className="form-label">출발 날짜:</label>
                        <input type="date" className="form-control" id="journeyStartDate" name="journeyStartDate" value={formData.journeyStartDate} onChange={handleChange} required />
                    </div>
                    <div className="col-md-6">
                        <label htmlFor="journeyEndDate" className="form-label">도착 날짜:</label>
                        <input type="date" className="form-control" id="journeyEndDate" name="journeyEndDate" value={formData.journeyEndDate} onChange={handleChange} required />
                    </div>
                </div>
                <button type="submit" className="btn btn-primary">등록</button>
            </form>
        </div>
    );
}