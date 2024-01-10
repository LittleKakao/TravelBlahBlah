//
//  APIEndpoints.swift
//  TravelBlahBlah
//
//  Created by BBangGiJin on 1/4/24.
//

import Foundation

struct APIEndpoints {
    
    static func createJourney(with createJourneyRequestDTO: CreateJourneyRequestDTO) -> Endpoint<CreateJourneyRequestDTO> {
        
        return Endpoint(
            path: "journey",
            method: .post,
            bodyParametersEncodable: createJourneyRequestDTO,
            responseDecoder: JSONResponseDecoder()
        )
    }
}
