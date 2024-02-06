//
//  APIEndpoints.swift
//  TravelBlahBlah
//
//  Created by BBangGiJin on 1/4/24.
//

import Foundation

struct APIEndpoints {
    
    static func getJourney(with getJourneyRequestDTO: GetJourneyRequestDTO) -> Endpoint<GetJourneyResponseDTO> {
        
        return Endpoint(
            path: "journey/all/0",
            method: .get,
            queryParametersEncodable: getJourneyRequestDTO,
            responseDecoder: JSONResponseDecoder()
        )
    }
    
    static func createJourney(with createJourneyRequestDTO: CreateJourneyRequestDTO) -> Endpoint<CreateJourneyResponseDTO> {
        
        return Endpoint(
            path: "journey",
            method: .post,
            bodyParametersEncodable: createJourneyRequestDTO,
            responseDecoder: JSONResponseDecoder()
        )
    }
}
