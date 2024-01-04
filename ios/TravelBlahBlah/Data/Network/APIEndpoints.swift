//
//  APIEndpoints.swift
//  TravelBlahBlah
//
//  Created by BBangGiJin on 1/4/24.
//

import Foundation

struct APIEndpoints {
    
    static func createJourney(with createJourneyRequestDTO: createJourneyRequestDTO) -> Endpoint<createJourneyRequestDTO> {
        
        return Endpoint(
            path: "journey",
            method: .post,
            bodyParametersEncodable: createJourneyRequestDTO,
            responseDecoder: JSONResponseDecoder()
        )
    }
}
