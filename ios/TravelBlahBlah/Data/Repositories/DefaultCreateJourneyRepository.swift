//
//  DefaultCreateJourneyRepository.swift
//  TravelBlahBlah
//
//  Created by BBangGiJin on 1/10/24.
//

import Foundation

protocol CreateJourneyRepository {
    func createJourney(
        journeyNm: String,
        journeyDest: String,
        completion: @escaping (Result<CreateJourneyResponseDTO, Error>) -> Void
    ) -> Cancellable?
}

final class DefaultCreateJourneyRepository {
    
    private let dataTransferService: DataTransferService
    private let backgroundQueue: DataTransferDispatchQueue
    
    init(
        dataTransferService:DataTransferService,
        backgroundQueue: DataTransferDispatchQueue = DispatchQueue.global(qos: .userInitiated)
    ) {
        self.dataTransferService = dataTransferService
        self.backgroundQueue = backgroundQueue
    }
}

extension DefaultCreateJourneyRepository: CreateJourneyRepository {
    
    func createJourney(journeyNm: String, journeyDest: String, completion: @escaping (Result<CreateJourneyResponseDTO, Error>) -> Void) -> Cancellable? {
        
        let journey = CreateJourneyRequestDTO(journeyNm: journeyNm, journeyDest: journeyDest)
        let endpoint = APIEndpoints.createJourney(with: journey)
        let task = RepositoryTask()
        
        task.networkTask = self.dataTransferService.request(with: endpoint, on: backgroundQueue, completion: { result in
            switch result {
            case .success(let responseDTO):
                completion(.success(responseDTO))
            case .failure(let error):
                completion(.failure(error))
            }
        })
        
        return task
    }
}
