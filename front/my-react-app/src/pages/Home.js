import React, { useState, useEffect } from "react";
import { Link } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';

export default function Home() {
    const [travelList, setTravelList] = useState([]);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        const fetchTravelList = async () => {
            try {
                // 여행 리스트를 가져오는 API 호출
                const response = await fetch('http://15.165.184.182:8080/journey/all/0');
                const responseData = await response.json();
                console.log("responseData: ", responseData);
                // 여행 데이터만 추출하여 설정합니다.
                const data = responseData.data.map(journey => ({
                    id: journey.journeyId,
                    name: journey.journeyName,
                    destination: journey.journeyDestination,
                    startDate: journey.journeyStartDate,
                    endDate: journey.journeyEndDate,
                    createDate: journey.journeyCreateDate,
                    updateDate: journey.journeyUpdateDate,
                    deleteYn: journey.journeyDeleteYn
                }));
                setTravelList(data);

                setLoading(false);
            } catch (error) {
                console.error('Error fetching travel list:', error);
            }
        };

        fetchTravelList();
    }, []);
    return (
        <div className="container">
            {loading ? (
                <p>Loading...</p>
            ) : (
                <div>
                    <table className="table table-striped">
                        <thead>
                        <tr>
                            <th>여행 이름</th>
                            <th>여행 목적지</th>
                            <th>시작일</th>
                            <th>종료일</th>
                        </tr>
                        </thead>
                        <tbody>
                        {travelList.map((travel, index) => (
                            <tr key={index}>
                                <td>{travel.name}</td>
                                <td>{travel.destination}</td>
                                <td>{travel.startDate}</td>
                                <td>{travel.endDate}</td>
                            </tr>
                        ))}
                        </tbody>
                    </table>
                    <Link to="/journey/create">
                        <button className="btn btn-primary">여행등록</button>
                    </Link>
                </div>
            )}
        </div>
    );
}